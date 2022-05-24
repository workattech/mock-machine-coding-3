import string
import random


class IdGenerator(object):
    generatedIds = set()

    @staticmethod
    def getStringId():
        randomString = ''.join([random.choice(string.ascii_letters
                                              + string.digits) for _ in range(10)])
        return randomString

    @classmethod
    def generateUniqueId(cls):
        randomString = cls.getStringId()
        while randomString in cls.generatedIds:
            randomString = cls.getStringId()
        cls.generatedIds.add(randomString)
        return randomString


class Access(object):
    PRIVATE = "PRIVATE"
    PUBLIC = "PUBLIC"


