package com.softwaretesting.alienware.services;

public class AuthServiceTest {
    @InjectMocks
    private AuthService authService;

    void should_return_success_when_call_plus_with_number1_and_number2(){
        boolean result = authService.compare("Admin","Admin1234");
        assertEquals(true,result);
    }
}
