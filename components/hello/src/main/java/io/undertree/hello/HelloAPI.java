package io.undertree.hello;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@Api(value = "NOOOO",
		description="Operations pertaining to Hello")
public interface HelloAPI {


	@ApiOperation(value = "Side Notes: View a specific Hello record",
			notes = "Implementation Notes: Foo!",
			response = HelloRecord.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved Hello"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	ResponseEntity<HelloRecord> hello(
			@ApiParam(name = "GOO", required = true)
			@PathVariable Long id);
}
