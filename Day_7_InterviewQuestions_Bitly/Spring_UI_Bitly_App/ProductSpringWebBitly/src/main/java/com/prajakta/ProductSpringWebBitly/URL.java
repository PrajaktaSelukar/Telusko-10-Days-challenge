package com.prajakta.ProductSpringWebBitly;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="shortner_url")
@Data
public class URL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String input_url;
    private String output_url;

    public URL(){}


    public URL(String input_url, String output_url) {
        this.input_url = input_url;
        this.output_url = output_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInput_url() {
        return input_url;
    }

    public void setInput_url(String input_url) {
        this.input_url = input_url;
    }

    public String getOutput_url() {
        return output_url;
    }

    public void setOutput_url(String output_url) {
        this.output_url = output_url;
    }
}
