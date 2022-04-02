# domain-name-converter
The app is responsible for domain name conversion, i.e. it can convert long domain names to short domain names, and can also decode short domain names back to long domain names. If you want to know more about long and short domains, you can refer to google.

## API endpoints
- Convert a long domain name to short domain name

   When passing the long domain name in the parameter, you can return the encoded short domain name. 
   
    API example:
   `curl --location --request GET 'localhost:8888/domain/encode?longName={longName}'`

- Return the long domain name given a short domain name

  When passing the short domain name in the parameter, you can return the original long domain name. If the decoded short domain name cannot be found in the system, a NOT_FOUND status code will be returned.

  API example:
`curl --location --request GET 'localhost:8888/domain/decode?shortName={shortName}'`

## Try it out

After starting this application, you can access its swagger ui at http://localhost:8888/swagger-ui and you will see all the api endpoints. You can easily try the api in this page.

## Test
You can run `./gradlew test` to run all tests. After the test is complete. This is the current test coverage report at `document/test_coverage_report.png` with 93% coverage.

## Design document
Refer to the documentation in the `document` folder for more information on application design.
