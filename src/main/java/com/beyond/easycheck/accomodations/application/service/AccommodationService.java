package com.beyond.easycheck.accomodations.application.service;

import com.beyond.easycheck.accomodations.infrastructure.entity.AccommodationEntity;
import com.beyond.easycheck.accomodations.infrastructure.repository.AccommodationRepository;
import com.beyond.easycheck.accomodations.ui.requestbody.AccommodationCreateRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class AccommodationService {

    private final AccommodationRepository accommodationRepository;

    @Transactional
    public Optional<AccommodationEntity> createAccommodation(AccommodationCreateRequest accommodationCreateRequest) {

        AccommodationEntity accommodationEntity = AccommodationEntity.builder()
                .name(accommodationCreateRequest.getName())
                .address(accommodationCreateRequest.getAddress())
                .accommodationType(accommodationCreateRequest.getAccommodationType())
                .build();

        return Optional.of(accommodationRepository.save(accommodationEntity));
    }
}
