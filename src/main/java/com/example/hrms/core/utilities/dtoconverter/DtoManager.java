package com.example.hrms.core.utilities.dtoconverter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class DtoManager implements DtoService{

    private ModelMapper modelMapper;

    @Autowired
    public DtoManager(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public <S, T> List<T> dtoConverter(List<S> s, Class<T> targetClass) {
        return s.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
    }

    @Override
    public <T> Object dtoClassConverter(Object source, Class<T> baseClass) {
        return modelMapper.map(source,baseClass);
    }
}
