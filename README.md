# domain-name-converter
This application is responsible for domain name conversion, which means it can convert long domain name to short domain name, also can decode short domain name back to long domain name. If you want to know more about long domain name and short domain name, you can refer to google.

## API endpoints
- convert a long domain name to short domain name.

   when pass long domain name in the parameter, it can return the encoded short domain name
   `curl --location --request GET '/domain/encode?longName={longName}'`

- locate the long domain name given a short domain name

   when pass encoded short domain name in the parameter, it can return the original long domain name. if the decoded short domain name cannot be found in system, it will return NOT_FOUND status code.
`curl --location --request GET 'localhost:8888/domain/decode?shortName={shortName}'`

## Test
You can run `./gradlew test` to run all the tests. After test finished, you can get the test report at `build/jacoco/test/index.html`

## Design document
Refer to the document under `document` folder, you can get more information about how the application is designed.
