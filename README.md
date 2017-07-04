# VAScanAPI
GraphQL API for VAScan Project.

Requirements
* Java 8
* MongoDB 3.2 or higher
* Gradle

Query example

```
{
	"query": "query($user: String!){ experiments ( user: $user ) { name } }",
	"variables": {
		"user": "1234"
	}
}
```

Mutation example

```
{
	"query": "mutation($id: String!, $name: String!, $description: String!, $startDate: String!, $endDate: String!){
	    updateExperiment ( id: $id, name: $name, description: $description, startDate: $startDate, endDate: $endDate ) { id, name }
	}",
	"variables": {
		"id": "595a8c896c8b34178a19b2ae",
		"name": "sed",
		"description": "bar",
		"startDate": "10-10-2017",
		"endDate": "10-11-2017"
	}
}
```