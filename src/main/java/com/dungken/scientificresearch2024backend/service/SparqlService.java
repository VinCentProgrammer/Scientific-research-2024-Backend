package com.dungken.scientificresearch2024backend.service;


import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.springframework.stereotype.Service;

@Service
public class SparqlService {
    public String executeSparqlQuery(String endpointURL, String query) {
        StringBuilder result = new StringBuilder();
        try (QueryExecution queryExec = QueryExecutionFactory.sparqlService(endpointURL, query)) {
            ResultSet resultSet = queryExec.execSelect();
            while (resultSet.hasNext()) {
                QuerySolution qs = resultSet.next();
                result.append(qs.toString()).append("\n");
            }
        }
        return result.toString();
    }
}