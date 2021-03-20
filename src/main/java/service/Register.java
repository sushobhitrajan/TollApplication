package service;

import model.Toll;

public interface Register<I,O> {

	O create(I input);
}
