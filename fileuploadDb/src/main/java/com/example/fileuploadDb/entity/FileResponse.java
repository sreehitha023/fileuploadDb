package com.example.fileuploadDb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileResponse
{
    @Id
    private String id;

    private String type;

    private String name;

}
