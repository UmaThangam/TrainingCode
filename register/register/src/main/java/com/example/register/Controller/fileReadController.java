package com.example.register.Controller;

import com.example.register.Service.fileReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("file_read")
public class fileReadController {

    @Autowired
    com.example.register.Service.fileReadService fileReadService;

    String UPLOADED_FOLDER="C:\\Users\\10592\\Downloads\\";

    @GetMapping(value = "Readimg/{name}", produces ="txt/csv")
    public ResponseEntity Readimg(@PathVariable String name) throws IOException {
        File file = new File("C:\\Users\\10592\\Downloads\\"+name);
        List<Map<String ,String>> mapList= this.fileReadService.fileRead(String.valueOf(file));
        return ResponseEntity.ok(mapList);
    }

    @PostMapping("uploadMutliFile")
    public ResponseEntity uploadFiles(@RequestParam MultipartFile[] file, @RequestParam Integer Id){
        try{
            for(MultipartFile f:file){
                String fileName = f.getOriginalFilename();
                String folderWithName = UPLOADED_FOLDER+fileName;
                Path path = Paths.get(folderWithName);//set path with filename
                Files.write(path, f.getBytes());//write the file in the location
            }
            return ResponseEntity.ok("file"+file.length);//return the file name

        }catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());//response with obj
        }
    }
}
