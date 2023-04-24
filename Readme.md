### Cache Implementation
Caching :is an intermediate storage that retains data for repeat access. It reduces the time needed to access the data again. Caches represent a transparent layer between the user and the actual source of the data. The process for saving data in a cache is called “caching.”

Advantages:
- Huge increase in speed.
- Load reduction for the system behind the cache.
- to improve latency among layers.

Disadvantages:
- Cache invalidation is difficult.

## @Cacheable
- used with the methods that are cacheable.
- cachemanager
- cacheResolver
- Synchronized Caching

```
@Cacheable(cacheNames = "employee",key = "#empId")
	public Employee getEmp(Integer empId) {
		System.out.println("Get API H2 Database Calling !.");
		return employeeRepository.findById(empId).get();
	}
```

other methods like : condition="#empname.length()<32",sync=true/false


## @CachePut
- to update the cache.

		```
		@CachePut(cacheNames = "employee" , key = "employee.empID")
			public Employee updateEmp(Employee employee) {
				System.out.println("Update API H2 Database Calling !.");
				return employeeRepository.save(employee);
			}
		```
## @CacheEvict
- to delete the cache

		```
		@CacheEvict(cacheNames="employee",key = "#empId")
			public String deleteEmp(Integer empId) {
				System.out.println("Delete API H2 Database Calling !.");
				employeeRepository.deleteById(empId);
				return "Employee Deleted Successfully";
			}
		```
## @Caching
- To specify multiple annotations of the same type such as @CacheEvict or @CachePut
