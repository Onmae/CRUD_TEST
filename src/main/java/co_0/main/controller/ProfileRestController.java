package com0.main.controller;

import com0.main.domain.Profile;
import com0.main.service.ProfileService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.rmi.PortableRemoteObject;

import static org.springframework.hateoas.PagedResources.*;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api/profiles")
public class ProfileRestController {

    private ProfileService profileService;

    public ProfileRestController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProfile(){
        List<Profile> profiles = profileService.findProfileList();
        return ResponseEntity.ok(profiles);
    }
    @PostMapping
    public ResponseEntity<?> postProfile(@RequestBody Profile profile) {
        profile.setCreatedDate((LocalDateTime.now()));
        profileService.newProfile(profile);
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }

    @PutMapping("/{idx}")
    public ResponseEntity<?> putProfile(@PathVariable("idx")Long idx, @RequestBody Profile profile) {
        Profile persistProfile = profileService.profileGetOne(idx);
        persistProfile.update(profile);
        profileService.newProfile(persistProfile);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @DeleteMapping("/{idx}")
    public ResponseEntity<?> deleteProfile(@PathVariable("idx")Long idx) {
        profileService.deleteProfile(idx);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
}
