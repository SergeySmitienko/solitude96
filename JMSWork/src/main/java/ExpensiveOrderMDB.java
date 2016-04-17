import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by skeep on 07.04.2016.
 */
@MessageDriven(mappedName = "jms/jaaee7/Topic",activationConfig = {
        @ActivationConfigProperty(propertyName = "acknowledgeMode",propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "messageSelector",propertyValue = "orderAmount > 100")
})
public class ExpensiveOrderMDB implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            OrderDTO order = message.getBody(OrderDTO.class);
            System.out.println("Большой заказ получен: " + order.toString());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
