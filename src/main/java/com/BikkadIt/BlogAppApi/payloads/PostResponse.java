package com.BikkadIt.BlogAppApi.payloads;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostResponse {

	private List<PostDto> content;
	private  int PageNumber;
	private int PageSize;
	private long totalElements;
	private  int totalpages;
	private boolean lasPage;
	
	
}
