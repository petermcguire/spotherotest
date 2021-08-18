# SpotHero Test Solution
SpotHero Engineering Manager take home test solution.

https://github.com/spothero/eng-mgr-take-home-challenge

## Instructions

Clone this repository and run `docker-compose up -d` to bring up both the `db` and the `api-server` services, the latter of which is the functional solution to this test.  Any viable REST client can be used to test the solution against the requirements.

### Automated Test

Simple integration testing is included, which is accessible by running `make run-tests` in the root directory.

## Notes
- Only integration testing is carried out.  Preferably unit testing would be also included.
- Command line testing output is very messy.  Use of Intellij is much nicer.
- `api-server` has no db auto reconnect or delayed start until a db is connected.
- `api-server` shuts down ungracefully, ideally this would not be the case.
- The requirements show the `hours` element of `worked_hours` as type `string`, while the POST request shows it as a double.  This is maintained in the solution but required some special treatment.  Ideally a single type would be used for both cases.
- Further, if the POST body object included `id`, the code could be limited to one model only for `worked_hours`.
