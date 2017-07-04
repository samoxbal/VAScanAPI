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
