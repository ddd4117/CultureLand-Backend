package org.nexters.cultureland.api.diary.service;

import org.modelmapper.ModelMapper;
import org.nexters.cultureland.api.diary.Diaries;
import org.nexters.cultureland.api.diary.DiaryDto;
<<<<<<< HEAD
import org.nexters.cultureland.api.diary.model.Diary;
import org.nexters.cultureland.api.diary.repository.DiaryRepository;
=======
import org.nexters.cultureland.api.diary.repository.DiaryRepository;
import org.nexters.cultureland.api.diary.model.Diary;
>>>>>>> 70dcb2ed5f100a7f957668c6b2e51e47645c6064
import org.nexters.cultureland.common.excepion.NotFoundDiaryException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DiaryService {

    private static final String NOT_FOUND_ERROR_MESSAGE = "존재하지 않는 기록입니다.";
    private final DiaryRepository diaryRepository;
    private final ModelMapper modelMapper;

    public DiaryService(final DiaryRepository diaryRepository, final ModelMapper modelMapper) {
        this.diaryRepository = diaryRepository;
        this.modelMapper = modelMapper;
    }

    public Diaries fetchDiaries() {
        return new Diaries(diaryRepository.findAll());
    }

    public Diary create(final DiaryDto diaryDto) {
        Diary diary = diaryRepository.save(modelMapper.map(diaryDto, Diary.class));

        return diary;
    }

    public Diary getDiaryOf(final Long diaryId) {
        return diaryRepository.findById(diaryId)
                .orElseThrow(() -> new NotFoundDiaryException(NOT_FOUND_ERROR_MESSAGE));
    }

    public Diary updateDiaryOf(final Long diaryId, DiaryDto diaryDto) {
        Diary diary = getDiaryOf(diaryId);
        diary.update(diaryDto);
        return diaryRepository.save(diary);
    }

    public void deleteDiaryOf(final Long diaryId) {
        Diary diary = diaryRepository.findById(diaryId).orElseThrow(() -> new NotFoundDiaryException(NOT_FOUND_ERROR_MESSAGE));
        diaryRepository.delete(diary);
    }
}
