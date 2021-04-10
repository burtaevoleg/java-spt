package Practice08.State.States;

import Practice08.State.DocumentContext;
import Practice08.State.IDocumentState;
import Practice08.State.StatusName;

public class DocumentDelivered implements IDocumentState {

    @Override
    public void nextDocumStatus(DocumentContext documentContext) {
        System.out.println("DocumentAccept nextDocumStatus NOTHING happens");

    }

    @Override
    public void previousDocumStatus(DocumentContext documentContext) {
        documentContext.setiDocumentState(new DocumentSend());
    }

    @Override
    public String getStatusName() {
        return StatusName.DELIVERED.getStatusName();
    }
}
