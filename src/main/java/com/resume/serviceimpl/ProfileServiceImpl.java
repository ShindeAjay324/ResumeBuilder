package com.resume.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resume.dto.EducationDetailsDto;
import com.resume.dto.ProfileDto;
import com.resume.dto.ProjectDetailsDto;
import com.resume.dto.SummaryDto;
import com.resume.entity.AchievementDetails;
import com.resume.entity.EducationDetails;
import com.resume.entity.Profile;
import com.resume.entity.ProjectDetails;
import com.resume.entity.Skills;
import com.resume.entity.Summary;
import com.resume.entity.User;
import com.resume.exception.AchievementDetailsException;
import com.resume.exception.ResumeException;
import com.resume.exception.UserIdNotFoundException;
import com.resume.repository.ProfileRepository;
import com.resume.repository.UserRepository;
import com.resume.service.ProfileService;
@Service
public class ProfileServiceImpl implements ProfileService {
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public ProfileDto resumeInfo(ProfileDto profileDto, Integer userId)  {
		try {
		Profile profile=new Profile();
		BeanUtils.copyProperties(profileDto, profile);
		
		//Achievement Data
			AchievementDetails achievementDetails=new AchievementDetails();
			BeanUtils.copyProperties(profileDto.getAchievementDetails(),achievementDetails );
			profile.setAchievementDetails(achievementDetails);
		
		//Educational Detail data
		List<EducationDetailsDto> educationDetailsDto=profileDto.getDetails();
		List<EducationDetails> educationDetailList =new ArrayList<>();
		educationDetailsDto.forEach(e->{
			EducationDetails educationDetail=new EducationDetails();
			BeanUtils.copyProperties(e, educationDetail);
			educationDetail.setProfile(profile);
			educationDetailList.add(educationDetail);
		});
		profile.setDetails(educationDetailList);
		
		//ProjectDetails
		List<ProjectDetailsDto> projectDetailsDtos=profileDto.getProjectDetails();
		List<ProjectDetails> projectDetails=new ArrayList<>();
		projectDetailsDtos.forEach(e->{
			ProjectDetails projectDetail=new ProjectDetails();
			BeanUtils.copyProperties(e, projectDetail);
			projectDetail.setProfile(profile);
			projectDetails.add(projectDetail);
		});
		profile.setProjectDetails(projectDetails);
		
		
		//Skill details
		Skills skills=new Skills();
		BeanUtils.copyProperties(profileDto.getSkills(), skills);
		profile.setSkills(skills);
		
		//Summary Data
		List<SummaryDto> summaryDtos=profileDto.getSummary();
		List<Summary> summaries=new ArrayList<>();
		summaryDtos.forEach(e->{
			Summary summary=new Summary();
			BeanUtils.copyProperties(e, summary);
			summaries.add(summary);
			summary.setProfile(profile);
		});
		profile.setSummary(summaries);
		
		//User by it's Id
		User user=userRepository.findById(userId).orElseThrow(() -> new UserIdNotFoundException("User not found" + userId));
		profile.setUser(user);
		
		profileRepository.save(profile);
		} catch (Exception e2) {
			 new ResumeException("Something Went Wrong");
		}
		return profileDto;
	}

}
