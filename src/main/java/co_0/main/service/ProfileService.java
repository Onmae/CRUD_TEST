package co_0.main.service;

import co_0.main.domain.Profile;
import co_0.main.repository.ProfileRepository;
import org.springframework.stereotype.Service;

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

    public void deleteProfile(Long idx) {
        profileRepository.deleteById(idx);
    }

    public Profile profileGetOne(Long idx) {
        return profileRepository.getOne(idx);
    }

}
