package com.wyzy.hospital.admin.kit.impl;

import com.wyzy.hospital.admin.api.dto.PhysicalSymptomDTO;
import com.wyzy.hospital.admin.api.entity.PhysicalSymptom;
import com.wyzy.hospital.admin.kit.PhysicalFitnessKitService;
import com.wyzy.hospital.admin.service.PhysicalSymptomService;
import com.wyzy.hospital.admin.service.impl.PhysicalFitnessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: PhysicalFitnessService
 * @Description:
 * @Auther: SongM
 * @Version: 1.0
 * @create 2021/6/17 11:08
 */
@Service
public class PhysicalFitnessKitServiceImpl implements PhysicalFitnessKitService {

    @Autowired
    private PhysicalFitnessServiceImpl physicalFitnessService;

    @Autowired
    private PhysicalSymptomService physicalSymptomService;

    @Override
    public List<PhysicalSymptomDTO> symptomTree() {
        /**
         *获取全部的数据
         */
       List<PhysicalSymptom> physicalSymptomList = physicalSymptomService.symptomTree();
        List<PhysicalSymptomDTO> physicalSymptomDTOList = treeSymptom(physicalSymptomList);
        return physicalSymptomDTOList;
    }

    private List<PhysicalSymptomDTO> treeSymptom(List<PhysicalSymptom> list) {
        List<PhysicalSymptomDTO> physicalSymptomDTOList =new ArrayList<>();
        for(PhysicalSymptom physicalSymptom: list){
            PhysicalSymptomDTO physicalSymptomDTO =new PhysicalSymptomDTO();
            if(physicalSymptom.getSuperiorId()== 0 || physicalSymptom.getSuperiorId()==-1){
                physicalSymptomDTO.setId(physicalSymptom.getId());
                physicalSymptomDTO.setSymptomName(physicalSymptom.getSymptomName());
                physicalSymptomDTO.setSuperiorId(physicalSymptom.getSuperiorId());
                physicalSymptomDTOList.add(physicalSymptomDTO);
            }
        }
        List<PhysicalSymptom> lis = null;
        for(PhysicalSymptomDTO physicalSymptomDTO:physicalSymptomDTOList){
            Long fId=physicalSymptomDTO.getId();
             lis = new ArrayList<>();
            for(PhysicalSymptom phy: list){
                if(phy.getSuperiorId().equals(fId)){
                    lis.add(phy);
                }
            }

        for(PhysicalSymptom physicalSymptom :lis){
                Long fId1 = physicalSymptom.getId();
                List<PhysicalSymptom> lis1 = new ArrayList<>();
                for(PhysicalSymptom phy: list){
                    if(phy.getSuperiorId().equals(fId1)){
                        lis1.add(phy);
                    }
                }
                physicalSymptom.setChildren(lis1);
            }

            physicalSymptomDTO.setChildren(lis);
        }




        return physicalSymptomDTOList;
    }
}
