package com.projects.rentACar.validation;

import com.projects.rentACar.core.result.Result;

public interface Validator<T> {

    Result validate(T dto);
}
