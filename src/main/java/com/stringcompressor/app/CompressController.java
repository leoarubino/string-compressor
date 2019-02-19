package com.stringcompressor.app;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class CompressController {
	@RequestMapping("/candidate")
	public Candidate candidate() {
		return new Candidate("Rubino", "Leo Andres", "33510567");
	}
	
	@RequestMapping("/")
	public String root() {
		return new String("ROOT");
	}

	@RequestMapping(value = "/compressParam/{value}", method = { RequestMethod.POST, RequestMethod.GET })
	public Compress compressData1(@PathVariable("value") String value) {
		try {
			return Compress.compressString(value);
		} catch (invalidCharExeption ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
		}
	}

	@PostMapping("/compress")
	public @ResponseBody Compress compressData(@RequestBody CompressInput compressData) {
		try {
			return Compress.compressString(compressData.getValue());
		} catch (invalidCharExeption ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
		}
	}
}
