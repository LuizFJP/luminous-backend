package com.br.luminous.mapper;

import com.br.luminous.entity.BillFile;
import com.br.luminous.models.BillFileRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BillFileMapper {
    public BillFile mapper(BillFileRequest billFileRequest){
        var billFile = new BillFile();

        BeanUtils.copyProperties(billFileRequest, billFile);
        return billFile;
    }
}
