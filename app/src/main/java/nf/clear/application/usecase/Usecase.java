package nf.clear.application.usecase;

import nf.clear.application.presenter.Presenter;

public interface Usecase<I> {
    Object execute (I input, Presenter present);
}
