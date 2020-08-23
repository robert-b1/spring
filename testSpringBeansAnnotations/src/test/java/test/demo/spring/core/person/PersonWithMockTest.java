package test.demo.spring.core.person;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import static org.mockito.Mockito.when;


@Slf4j
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = Application.class)
public class PersonWithMockTest extends TestCase {

    @Mock
    private Backpack backpack;
    @InjectMocks
    private Person person;
    @Test
    public void testBackpackCapacity(){
        //given
        final int mockedCapasityValue = 40;
        final int expectedResult = 40;
        //when
        when(backpack.getCapacity()).thenReturn(mockedCapasityValue);
        final int result = person.getBackpack().getCapacity();
        //then
        assertEquals(expectedResult, result);
    }

    @Test
    public void testBackpackMyObject(){
        //given
        final int mockedMyObject2 = 10;
        final int expectedResult2 = 10;
        //when
        when(backpack.getMyObject()).thenReturn(mockedMyObject2);
        final int result2 = person.getBackpack().getMyObject();
        //then
        assertEquals(expectedResult2, result2);
    }
}