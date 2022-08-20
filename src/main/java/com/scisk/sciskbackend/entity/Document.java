package com.scisk.sciskbackend.entity;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Document {
	private String name;
	private String path;
	private String extension;
	
	private Record record;
	
	private NeededDocument neededDocument;

}
