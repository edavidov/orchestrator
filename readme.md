
It's an API application that merges the result from three other APIs into a single model.
The result in JSON format is structured in its own model using the origin data to build it.


It integrates following APIs:
- https://corpwatch.org/
- https://www.mediawiki.org
- http://dbpedia.org

It's developed using `SpringBoot 2.0.5` and `Spring Framework 5`.

For UI is using `Swagger Test Client` 
http://localhost:8080/swagger-ui.html#/

Additionally, an example of the request URL is: http://localhost:8080/api/companies.json?company_name=Novartis

The APIOrchestrator can be used to search companies by:
- company name
- industry
- state
- country
- address

The CorpWatch API can be searched by all the criteria.

For searching companies by country, a special country code should be used. For example: US for United States, DE for Denmark.

The state parameter includes codes for all the states in the US.For example: CA, MA,FL,IL etc.

For searching companies by industries, specific industry names should be used available at http://api.corpwatch.org/industryCodes.json .

For example: Pharmaceutical preparations , Medicinal Chemicals & Botanical Products and etc.

DBpedia and MediaWiki APIs can be searched only by company name.


APIOrchestrator: `java -jar orchestrator.jar`

 
 
