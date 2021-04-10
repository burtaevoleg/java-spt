package Practice08.State.States;

import Practice08.State.DocumentContext;
import Practice08.State.IDocumentState;
import Practice08.State.StatusName;

public class DocumentNew implements IDocumentState {
    @Override
    public void nextDocumStatus(DocumentContext documentContext) {
        documentContext.setiDocumentState(new DocumentSend());

    }
    @Override
    public void previousDocumStatus(DocumentContext documentContext) {
        System.out.println("DocumentNew previousDocumStatuc NOTHING happens");
    }

    @Override
    public String getStatusName() {
        return StatusName.NEW.getStatusName();
    }
}
