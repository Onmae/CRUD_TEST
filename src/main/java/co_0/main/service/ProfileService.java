package com0.main.service;

import com0.main.domain.Profile;
import com0.main.repository.ProfileRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;

    }
    public List<Profile> findProfileList() {
        return profileRepository.findAll();
    }


    public Profile findProfileByIdx(Long idx) {

        return profileRepository.findById(idx).orElse(new Profile());
    }

    public Profile newProfile(Profile profile) {
        return profileRepository.save(profile);

    }

    public void deleteProfile(Long idx){
        profileRepository.deleteById(idx);
    }

    public Profile profileGetOne(Long idx){
        return profileRepository.getOne(idx);
    }

}
