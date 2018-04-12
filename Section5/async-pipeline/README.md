## To run....

### Glassfish 5
- `mvn clean package` - will create `booking.war` in `target`
- Copy  `booking.war` to `<glassfish.home>/glassfish/domains/<domainname>/autodeploy` (e.g. `<C:\glassfish5\glassfish\domains\domain1\autodeploy`)
- Run ! `<glassfish.home>/glassfish/bin/asadmin start-domain`
- hold on... a few moments
- you should see a message like this `Successfully started the domain : domain1`

## Test it...

- `curl http://localhost:8080/booking/cabs/abhi`
- hold on... 3-5 seconds
- you should see a message like this - `Your driver is john doe and OTP is 1234`

That's it..