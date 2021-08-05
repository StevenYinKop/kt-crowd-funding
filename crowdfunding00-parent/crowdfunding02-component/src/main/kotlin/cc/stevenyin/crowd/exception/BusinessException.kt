package cc.stevenyin.crowd.exception

class BusinessException constructor(val exceptionCode: ExceptionCode): RuntimeException(exceptionCode.message)
