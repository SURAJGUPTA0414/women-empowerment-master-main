package com.capgemini.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.model.FeedBack;
import com.capgemini.model.NGO;
import com.capgemini.repository.IFeedBackRepository;
import com.capgemini.repository.INGORepository;
import com.capgemini.service.IFeedBackService;
import com.capgemini.service.INGOService;



@SpringBootTest
public class TestFeedbackController {

@MockBean
private  IFeedBackRepository repository;

@Autowired
private FeedbackController controller;
@Autowired
private IFeedBackService service;

//@Test
//public void testAddFeedback() {
//String motive = "add";
//when(repository.sa).thenReturn((List<FeedBack>)Stream.of(new FeedBack()).collect(Collectors.toList()));
//assertEquals(controller.viewNGOByMotive(motive),controller.viewNGOByMotive(motive));
//
//}

@Test
public void testgetAllFeedback() {

when(repository.findAll()).thenReturn((List<FeedBack>) Stream.of(new FeedBack()).collect(Collectors.toList()));
assertEquals(controller.viewAllFeedBack(),controller.viewAllFeedBack() );

}




//@Test
//public void testFeedbackbyId() {
//Integer id= 1;
//when(service.viewFeedBack(id)).thenReturn((FeedBack)Stream.of(new FeedBack()).collect(Collectors.toList()));
//assertEquals(controller.viewFeedBack(id),service.viewFeedBack(id));
//
//}

@Test
public void testAddFeedback () {
FeedBack feedback= new FeedBack(1, 0, 0, 0, null, null);
when(repository.save(feedback)).thenReturn(feedback);
assertEquals(controller.addFeedBack(feedback),controller.addFeedBack(feedback));

}
}