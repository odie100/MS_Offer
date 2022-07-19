package com.akata.application.services;

import com.akata.application.dto.ApplyRequestDTO;
import com.akata.application.dto.ApplyResponseDTO;
import com.akata.application.entities.Apply;
import com.akata.application.entities.Offer;
import com.akata.application.entities.Student;
import com.akata.application.mappers.ApplyMapper;
import com.akata.application.mappers.OfferMapper;
import com.akata.application.mappers.StudentMapper;
import com.akata.application.models.ApplyModel;
import com.akata.application.repository.ApplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    private ApplyRepository applyRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private OfferService offerService;

    @Autowired
    private ApplyMapper applyMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private OfferMapper offerMapper;

    @Override
    public ApplyResponseDTO save(ApplyModel applyModel) {
        Apply apply = this.applyMapper.applyModelTOApply(applyModel);
        Student student = this.studentMapper.studentReponseDTOStudent(this.studentService.getStudent(applyModel.getId_student()));
        Offer offer = this.offerMapper.offerResponseDTOOffer(this.offerService.getOffer(applyModel.getId_offer()));
        apply.setApply_date(LocalDate.now());
        apply.setStatus("en cours");
        apply.setOffer(offer);
        apply.setStudent(student);
        return this.applyMapper.applyToApplyResponseDTO(this.applyRepository.save(apply));
    }

    @Override
    public ApplyResponseDTO getApply(Long id) {
        return this.applyMapper.applyToApplyResponseDTO(this.applyRepository.findById(id).get());
    }

    @Override
    public ApplyResponseDTO update(Long id, ApplyRequestDTO applyRequestDTO) {
        Apply apply = this.applyMapper.applyRequestDTOApply(applyRequestDTO);
        apply.setId(id);
        return this.applyMapper.applyToApplyResponseDTO(this.applyRepository.save(apply));
    }

    @Override
    public boolean delete(Long id) {
        try {
            this.applyRepository.deleteById(id);
            return true;
        }catch (DataAccessException e){
            return false;
        }
    }

    @Override
    public List<ApplyResponseDTO> getAllApplies() {
        List<Apply> applies = this.applyRepository.findAll();
        return applies.stream().map(apply -> this.applyMapper.applyToApplyResponseDTO(apply))
                .collect(Collectors.toList());
    }
}
