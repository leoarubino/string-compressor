package com.stringcompressor.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompressControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void candidateShouldReturnMyData() throws Exception {

		this.mockMvc.perform(get("/candidate")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.lastName").value("Rubino")).andExpect(jsonPath("$.firstName").value("Leo Andres"))
				.andExpect(jsonPath("$.id").value("33510567"));
	}

	@Test
	public void compressDataBasic() throws Exception {
		this.mockMvc.perform(post("/compressParam/aaabb")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.compressed").value("3a2b"));
	}

	@Test
	public void compressDataCaseSentive() throws Exception {
		this.mockMvc.perform(post("/compressParam/AaAaAaBbBbBbTTTTTTttt")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.compressed").value("6a6b9t"));
	}

	@Test
	public void compressWithInvalidChar() throws Exception {
		this.mockMvc.perform(post("/compressParam/aaa1bbbb")).andDo(print()).andExpect(status().is4xxClientError());
	}

	@Test
	public void compressPostWithJsonBody() throws Exception {
		JSONObject jsonData = new JSONObject();
		jsonData.put("value", "aaaAa");
		this.mockMvc.perform(post("/compress")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonData.toString()))
		 .andExpect(status().isOk())
		 .andExpect(jsonPath("$.compressed").value("5a"));
	}
}