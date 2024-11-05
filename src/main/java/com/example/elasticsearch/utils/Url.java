package com.example.elasticsearch.utils;

public class Url {
    public static final String CREATE_INDEX = "http://localhost:9200/first17_index";
    public static final String DELETE_ALL_PRODUCTS = "http://localhost:9200/first17_index/_delete_by_query?conflicts=proceed";
    public static final String CREATE_ALL_PRODUCTS = "http://localhost:9200/first17_index/_bulk";
    public static final String SEARCH_PRODUCTS = "http://localhost:9200/first17_index/_search";
    public static final String REQUEST_BODY_INIT_INDEX = "{\n" +
            "    \"mappings\": {\n" +
            "        \"properties\": {\n" +
            "            \"name\": {\n" +
            "                \"type\": \"text\"\n" +
            "            },\n" +
            "            \"dateCreate\": {\n" +
            "                \"type\": \"date\"\n" +
            "            },\n" +
            "            \"scuDto\": {\n" +
            "               \"type\": \"nested\"\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "}";

    public static final String REQUEST_BODY_DELETE_DOCS = "{\n" +
            " \"query\": {\n" +
            " \"match_all\": {}\n" +
            " }\n" +
            "}";
}
