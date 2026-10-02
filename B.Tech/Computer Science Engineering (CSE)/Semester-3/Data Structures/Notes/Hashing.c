#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TABLE_SIZE 10

typedef struct Entry {
    char *key;
    int value;
    struct Entry *next;
} Entry;

typedef struct {
    Entry *entries[TABLE_SIZE];
} HashTable;

unsigned int hash(const char *key) {
    unsigned long int value = 0;
    unsigned int i = 0;
    unsigned int key_len = strlen(key);

    for (; i < key_len; ++i) {
        value = value * 37 + key[i];
    }

    value = value % TABLE_SIZE;
    return value;
}

Entry *create_entry(const char *key, int value) {
    Entry *entry = malloc(sizeof(Entry));
    entry->key = malloc(strlen(key) + 1);
    strcpy(entry->key, key);
    entry->value = value;
    entry->next = NULL;
    return entry;
}

HashTable *create_table() {
    HashTable *table = malloc(sizeof(HashTable));
    for (int i = 0; i < TABLE_SIZE; i++) {
        table->entries[i] = NULL;
    }
    return table;
}

void insert(HashTable *table, const char *key, int value) {
    unsigned int slot = hash(key);
    Entry *entry = table->entries[slot];

    if (entry == NULL) {
        table->entries[slot] = create_entry(key, value);
        return;
    }

    Entry *prev;
    while (entry != NULL) {
        if (strcmp(entry->key, key) == 0) {
            entry->value = value;
            return;
        }
        prev = entry;
        entry = entry->next;
    }

    prev->next = create_entry(key, value);
}

int search(HashTable *table, const char *key) {
    unsigned int slot = hash(key);
    Entry *entry = table->entries[slot];

    while (entry != NULL) {
        if (strcmp(entry->key, key) == 0) {
            return entry->value;
        }
        entry = entry->next;
    }

    return -1; // Key not found
}

void free_table(HashTable *table) {
    for (int i = 0; i < TABLE_SIZE; i++) {
        Entry *entry = table->entries[i];
        while (entry != NULL) {
            Entry *temp = entry;
            entry = entry->next;
            free(temp->key);
            free(temp);
        }
    }
    free(table);
}

int main() {
    HashTable *table = create_table();

    insert(table, "name", 1);
    insert(table, "age", 2);
    insert(table, "gender", 3);

    printf("name: %d\n", search(table, "name"));
    printf("age: %d\n", search(table, "age"));
    printf("gender: %d\n", search(table, "gender"));

    free_table(table);
    return 0;
}