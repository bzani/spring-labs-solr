package com.bdpz.labs.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@SolrDocument(solrCoreName = "products")
public class Product {
   
    @Id
    @Indexed(name = "id", type = "string")
    private String id;

    @Indexed(name = "name", type = "string")
    private String name;

}
