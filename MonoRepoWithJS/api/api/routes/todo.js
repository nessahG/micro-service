const express = require('express');
const router = express.Router();
const Todo = require('./../modules/todo');

// GET all todos
router.get('/', async (req, res, next) => {
  try {
    const todos = await Todo.find();
    res.status(200).json(todos);
  } catch (err) {
    next(err);
  }
});

// GET one todo by ID
router.get('/:id', async (req, res, next) => {
  try {
    const todo = await Todo.findById(req.params.id);
    if (!todo) {
      return res.status(404).send('Todo not found');
    }
    res.status(200).json(todo);
  } catch (err) {
    next(err);
  }
});

// CREATE a new todo
router.post('/', async (req, res, next) => {
  try {
    const todo = new Todo(req.body);
    await todo.save();
    res.status(201).json(todo);
  } catch (err) {
    next(err);
  }
});

// UPDATE a todo by ID
router.put('/:id', async (req, res, next) => {
  try {
    const todo = await Todo.findByIdAndUpdate(req.params.id, req.body, {
      new: true,
    });
    if (!todo) {
      return res.status(404).send('Todo not found');
    }
    res.status(200).json(todo);
  } catch (err) {
    next(err);
  }
});

// DELETE a todo by ID
router.delete('/:id', async (req, res, next) => {
  try {
    const todo = await Todo.findByIdAndDelete(req.params.id);
    if (!todo) {
      return res.status(404).send('Todo not found');
    }
    res.status(204).send();
  } catch (err) {
    next(err);
  }
});

module.exports = router;
