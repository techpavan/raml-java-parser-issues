package com.github.techpavan;

import org.raml.v2.api.RamlModelBuilder;
import org.raml.v2.api.RamlModelResult;
import org.raml.v2.api.model.v10.api.Api;
import org.raml.v2.api.model.v10.datamodel.TypeDeclaration;
import org.raml.v2.api.model.v10.methods.Method;
import org.raml.v2.api.model.v10.resources.Resource;

public class ParserTest {

    public static void main(String[] args) {
        RamlModelResult ramlModelResult = new RamlModelBuilder().buildApi("api.raml");
        Api api = ramlModelResult.getApiV10();
        for (Resource res : api.resources()) {
            System.out.println("\nPath: " + res.resourcePath());
            for (Method method : res.methods()) {
                for (TypeDeclaration param : method.queryParameters()) {
                    System.out.println("\tParameter: " + param.name());
                }
            }
        }
    }

}
