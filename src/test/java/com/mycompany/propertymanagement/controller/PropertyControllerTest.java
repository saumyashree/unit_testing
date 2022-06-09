package com.mycompany.propertymanagement.controller;
import  com.mycompany.propertymanagement.service.PropertyService;
import com.mycompany.propertymanagement.dto.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {
    @InjectMocks
    private PropertyController propertyController;//create proxy object of propertycontroller and inject it to our ControllerTest

    @Mock
    private  PropertyService propertyService;

    @Test
    @DisplayName("Test sucessS scenario for saving new property")
    void saveProperty(){

        PropertyDTO dto = new PropertyDTO();
        dto.setTitle("Dummy property");

        PropertyDTO saveProperty = new PropertyDTO();
        saveProperty.setId(1L);
        saveProperty.setTitle(dto.getTitle());
//do not make the actualcall for this lineinside controller rather return dummy object wich is set property
        Mockito.when(propertyService.saveProperty(dto)).thenReturn(saveProperty);
        ResponseEntity<PropertyDTO> responseEntity=propertyController.saveProperty(dto);
        Assertions.assertNotNull(responseEntity.getBody().getId());
        Assertions.assertEquals(HttpStatus.CREATED.value(),responseEntity.getStatusCode());

    }
}
