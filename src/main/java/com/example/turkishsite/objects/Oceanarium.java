package com.example.turkishsite.objects;

import com.example.turkishsite.Algorithm;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class Oceanarium {
    private List<Fish> fshs = new ArrayList<>();
    public void addFish(String... fns) {
        
        for (String fn: fns) {
            
            Fish nfsh = new Fish(fn);
            
            fshs.add(nfsh);
            
        }
    }

    public boolean exists(String fn) {
        return Algorithm
                
                .find(fshs.stream().map(fs -> fs.getFishName().toLowerCase()).toList(), fn.toLowerCase());
        
    }
}
