package com.ibm.pact;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;

@RunWith(SpringRestPactRunner.class)
//@SpringBootTest(classes=Application.class,properties={"spring.profiles.active=test","spring.cloud.config.enabled=false"},webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@PactBroker(host="${pact.host}",port="${pact.port}")
@Provider("booking_provider")
public class BookingProviderTest {
    @MockBean
    private BookingService bookingService;
  
    @TestTarget
    public final Target target = new HttpTarget(9050);
    
    @State(value="create booking")
    public void createBookingState() throws Exception{
        
        BookCargo bookCargo = new BookCargo (100, "CNHKG", "USNYC",  "2020-01-28");
        when(inventoryService.saveInventory(any(Inventory.class))).thenReturn(inventory) ;
    }
}