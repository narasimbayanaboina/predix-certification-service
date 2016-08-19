/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ge.predix.certification.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.ws.rs.core.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ge.predix.Application;
import com.ge.predix.certification.businessobject.CerttestitemBO;
import com.ge.predix.certification.domain.Certattemp;
import com.ge.predix.certification.domain.Certtestitem;
import com.ge.predix.certification.domain.Model;
import com.ge.predix.certification.repositories.CertattempRepository;
import com.ge.predix.certification.service.CertificationService;
import com.ge.predix.certification.utils.Status;

import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author Narasim Bayanaboina
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ModelControllerTest {

	@Autowired
	private WebApplicationContext ctx;
	@Autowired
	private CertificationService certificationService;
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
   
	@Test

	public void getTestModelList() throws Exception {

		this.mockMvc.perform(get("/certmodels"))
				.andDo(print())
				.andExpect(status().isOk());
				
	}

	@Test
	@Ignore
	public void getTestAttempList() throws Exception {

		this.mockMvc.perform(get("/certattemps"))
				.andDo(print())
				.andExpect(status().isOk());
				
	}

	

	@Test
	public void getTestCertTestItemsByAttemptId() throws Exception {

		this.mockMvc.perform(get("/certtestitems?certattempid=2"))
				.andDo(print())
				.andExpect(status().isOk());
				
	}
	
	@Test
//@Ignore
	public void getTestCertUserList() throws Exception {

		this.mockMvc.perform(get("/certusers"))
				.andDo(print())
				.andExpect(status().isOk());
				
	}
	
	@Test
	
	public void createNewModel() throws Exception {
		
		Model model = new Model();
	
		model.setAuthorname("Narasim");
		model.setPartnername("GE Power");
		model.setLongDesc("long desc  asdafewwwwwwwj greeeeeregergger");
		model.setEmail("eMail@ge.com");
		model.setModelname("Python Analytics Model");
		model.setProgramminglanguage("Python");
		model.setReason("Reason");
		model.setShortDesc("short desc");
		model.setStatus(Status.INITIAL.toString());
	
		
		
		java.util.Date date= new java.util.Date();
		Timestamp ts_now = new Timestamp(date.getTime());
		
		model.setLaststatustime(ts_now);
		model.setCreatedts(ts_now);
		model.setExternalId("MOD");
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		//String json = ow.writeValueAsString(model);
		 String jsonStr=null;
		  try {
	            
	          //  jsonStr = mapperObj.writeValueAsString(model);
			  jsonStr = ow.writeValueAsString(model);
	         
	        } catch (Exception e) {
	         
	            e.printStackTrace();
	        }


		this.mockMvc.perform(post("/certmodels").contentType(MediaType.APPLICATION_JSON).content(jsonStr))
				.andDo(print())
				.andExpect(status().isCreated());
				
	}
	
	@Test
	//@Ignore
	public void getTestGetModelbyId() throws Exception {

		this.mockMvc.perform(get("/certmodel/10"))
				.andDo(print())
				.andExpect(status().isOk());
				
	}
	
	@Test
	//@Ignore
	public void GetTestAttemptsByModelId() throws Exception {
		
	
		
		this.mockMvc.perform(get("/certattemps?modelid=2"))
		.andDo(print())
		.andExpect(status().isOk());
		/*
		List<Certattemp> list =certificationService.GetAttemptsByModelId(1);
		for (Certattemp certitem : list) {
			System.out.println("certitem:::::: "+certitem.toString());
		}*/
	
				
	}
	
	

	
}
