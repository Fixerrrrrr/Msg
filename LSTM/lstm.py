# coding=utf-8
import numpy as np
import os
import sys

reload(sys)
sys.setdefaultencoding('utf-8')
# import random
# random.seed(1337)
from keras.optimizers import Adam
from keras.preprocessing.text import Tokenizer
from keras.preprocessing.sequence import pad_sequences
from keras.utils.np_utils import to_categorical
from keras.models import Sequential
from keras.layers import Embedding, LSTM, Dense, Activation, Dropout
from keras.callbacks import EarlyStopping

DATAPATH = os.path.join(os.path.dirname(os.path.abspath(__file__)), 'data')
MAX_SEQUENCE_LENGTH = 50
NB_WORDS = 100000
EMBEDDING_DIM = 200
# VALIDATION_SPLIT = 0.2
batch_size = 64
nb_epoch = 50

labels_index = {}  # dictionary mapping label name to numeric id
texts_train = []  # list of text samples
labels_train = []  # list of label ids
texts_val = []
labels_val = []

trainFilePath = 'train.txt'
valFilePath = 'dev.txt'
with open(os.path.join(DATAPATH, trainFilePath)) as f:
    for line in f:
        values = line.split()
        label = values[0]
        if label not in labels_index.keys():
            labels_index[label] = len(labels_index)
        labels_train.append(labels_index[label])
        texts_train.append(unicode(line[len(label) + 1:]))
with open(os.path.join(DATAPATH, valFilePath)) as f:
    for line in f:
        values = line.split()
        label = values[0]
        labels_val.append(labels_index[label])
        texts_val.append(unicode(line[len(label) + 1:]))

# print labels_index.items()
# print texts_train[1003]
# print labels_train[1003]

embeddings_index = {}
with open('embedding.' + str(EMBEDDING_DIM), 'r') as f:
    for line in f:
        line_uni = line.decode('utf-8')
        values = line_uni.split()
        word = values[0]
        coefs = np.asarray(values[1:], dtype='float32')
        embeddings_index[word] = coefs

tokenizer = Tokenizer(num_words=NB_WORDS)
tokenizer.fit_on_texts(texts_train)
sequences = tokenizer.texts_to_sequences(texts_train)
word_index = tokenizer.word_index

x_train = pad_sequences(sequences, maxlen=MAX_SEQUENCE_LENGTH)
y_train = to_categorical(np.asarray(labels_train))
print('Shape of data tensor:', x_train.shape)
print('Shape of label tensor:', y_train.shape)

tokenizer = Tokenizer(num_words=NB_WORDS)
tokenizer.fit_on_texts(texts_val)
sequences = tokenizer.texts_to_sequences(texts_val)
word_index = tokenizer.word_index

x_val = pad_sequences(sequences, maxlen=MAX_SEQUENCE_LENGTH)
y_val = to_categorical(np.asarray(labels_val))
print('Shape of data tensor:', x_val.shape)
print('Shape of label tensor:', y_val.shape)

# tokenizer = Tokenizer(num_words=MAX_NB_WORDS)
# tokenizer.fit_on_texts(texts)
# sequences = tokenizer.texts_to_sequences(texts)
# word_index = tokenizer.word_index
#
# data = pad_sequences(sequences, maxlen=MAX_SEQUENCE_LENGTH)
# labels = to_categorical(np.asarray(labels))
# print('Shape of data tensor:', data.shape)
# print('Shape of label tensor:', labels.shape)

# indices = np.arange(data.shape[0])
# np.random.shuffle(indices)
# data = data[indices]
# labels = labels[indices]
# nb_validation_samples = int(VALIDATION_SPLIT * data.shape[0])
#
# x_train = data[:-nb_validation_samples]
# y_train = labels[:-nb_validation_samples]
# x_val = data[-nb_validation_samples:]
# y_val = labels[-nb_validation_samples:]

nb_words = min(NB_WORDS, len(word_index))
embedding_matrix = np.zeros((NB_WORDS + 1, EMBEDDING_DIM))

for word, i in word_index.items():
    if i > NB_WORDS:
        continue
    embedding_vector = embeddings_index.get(word)
    if embedding_vector is not None:
        # words not found in embedding index will be all-zeros.
        embedding_matrix[i] = embedding_vector

# print(embedding_matrix.shape)
# print embedding_matrix[76]


embedding_layer = Embedding(NB_WORDS + 1,
                            EMBEDDING_DIM,
                            weights=[embedding_matrix],
                            input_length=MAX_SEQUENCE_LENGTH,
                            dropout=0.2)

print('Build model...')
# sequence_input = Input(shape=(MAX_SEQUENCE_LENGTH,), dtype='int32')
# embedded_sequences = embedding_layer()
model = Sequential()
model.add(embedding_layer)
model.add(
    LSTM(300, dropout_W=0.2, dropout_U=0.2))  # try using a GRU instead, for fun
model.add(Dense(1))
model.add(Activation('tanh'))
model.add(Dense(len(labels_index), activation='softmax'))
model.layers[1].trainable = False

model.summary()
adam = Adam(lr=0.001)
model.compile(loss='categorical_crossentropy',
              optimizer=adam,
              metrics=['accuracy'])

print('Train...')
early_stopping = EarlyStopping(monitor='val_rmse', patience=5, mode='min')
model.fit(x_train, y_train, batch_size=batch_size, nb_epoch=nb_epoch, callbacks=[early_stopping],
          validation_data=(x_val, y_val))
score, acc = model.evaluate(x_val, y_val,
                            batch_size=batch_size)
print('Test score:', score)
print('Test accuracy:', acc)
