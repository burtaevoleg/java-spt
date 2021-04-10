package Practice08.State.States;

import Practice08.State.DocumentContext;
import Practice08.State.IDocumentState;
import Practice08.State.StatusName;

public class DocumentSend implements IDocumentState {

    @Override
    public void nextDocumStatus(DocumentContext documentContext) {
        documentContext.setiDocumentState(new DocumentDelivered());
    }

    @Override
    public void previousDocumStatus(DocumentContext documentContext) {
        documentContext.setiDocumentState(new DocumentNew());
    }

    @Override
    public String getStatusName() {
        return StatusName.SEND.getStatusName();
    }
}
