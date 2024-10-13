package com.beyond.easycheck.themeparks.application.service;

import com.beyond.easycheck.common.exception.EasyCheckException;
import com.beyond.easycheck.themeparks.application.service.ThemeParkReadUseCase.FindThemeParkResult;
import lombok.Builder;
import lombok.Getter;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.beyond.easycheck.themeparks.exception.ThemeParkMessageType.VALIDATION_FAILED;

public interface ThemeParkOperationUseCase {

    FindThemeParkResult saveThemePark(ThemeParkCreateCommand command, Long accommodationId, List<MultipartFile> imageFiles);

    FindThemeParkResult updateThemePark(Long id, ThemeParkUpdateCommand command, Long accommodationId);

    void updateThemeParkImages(Long id, List<MultipartFile> imageFiles);

    void deleteThemePark(Long id, Long accommodationId);

    @Getter
    @Builder
    class ThemeParkCreateCommand {
        private String name;
        private String description;
        private String location;

        private List<MultipartFile> imageFiles;
        public void validate() {
            if (name == null || name.trim().isEmpty()) {
                throw new EasyCheckException(VALIDATION_FAILED);
            }
            if (description == null || description.trim().isEmpty()) {
                throw new EasyCheckException(VALIDATION_FAILED);
            }
            if (location == null || location.trim().isEmpty()) {
                throw new EasyCheckException(VALIDATION_FAILED);
            }
        }
    }

    @Getter
    @Builder
    class ThemeParkUpdateCommand {
        private final String name;
        private final String description;
        private final String location;

        private List<MultipartFile> imageFiles;

        public void validate() {
            if (name == null || name.trim().isEmpty()) {
                throw new EasyCheckException(VALIDATION_FAILED);
            }
            if (description == null || description.trim().isEmpty()) {
                throw new EasyCheckException(VALIDATION_FAILED);
            }
            if (location == null || location.trim().isEmpty()) {
                throw new EasyCheckException(VALIDATION_FAILED);
            }
        }
    }
}
