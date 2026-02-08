# Poligono Details

## Project Description

The **Poligono** project is designed to check whether the points provided by a user form a polygon. The current implementation is a work-in-progress:

- The existing code is fully documented, offering insights into its implementation.
- Upcoming features include:
  - Creating a Spring-based UI to allow users to visually see the points.
  - Hosting the application on a website for easy accessibility.

## Usage

1. **Input Points**: Provide a set of points to the application that may form a polygon in a 2D plane.
2. **Validation**: The application processes these points and determines whether the points align to create a valid polygon shape.
3. **Output**: Feedback will be provided to indicate whether the points successfully construct a valid polygon.

### Planned Improvements:
- Interactive visualization using a Spring framework-based GUI.
- Web-based application version to make the functionality accessible over the internet.

## Examples

1. **Example 1: Adding Points to Form a Closed Polygon**  
   ```
   quale operazione vuoi eseguire? (i = inserisci, e = elimina, t = termina programma)
   Inserisci l'ascissa: 0
   Inserisci l'ordinata: 0
   quale operazione vuoi eseguire? (i = inserisci, e = elimina, t = termina programma)
   Inserisci l'ascissa: 4
   Inserisci l'ordinata: 0
   quale operazione vuoi eseguire? (i = inserisci, e = elimina, t = termina programma)
   Inserisci l'ascissa: 4
   Inserisci l'ordinata: 4
   quale operazione vuoi eseguire? (i = inserisci, e = elimina, t = termina programma)
   Inserisci l'ascissa: 0
   Inserisci l'ordinata: 4
   quale operazione vuoi eseguire? (i = inserisci, e = elimina, t = termina programma)
   t
   (0, 0)
   (4, 0)
   (4, 4)
   (0, 4)
   Poligono chiuso.
   ```

2. **Example 2: Adding and Removing Points**  
   ```
   quale operazione vuoi eseguire? (i = inserisci, e = elimina, t = termina programma)
   Inserisci l'ascissa: 1
   Inserisci l'ordinata: 1
   quale operazione vuoi eseguire? (i = inserisci, e = elimina, t = termina programma)
   Inserisci l'ascissa: 2
   Inserisci l'ordinata: 2
   quale operazione vuoi eseguire? (i = inserisci, e = elimina, t = termina programma)
   t
   (1, 1)
   (2, 2)
   Poligono chiuso.
   ```