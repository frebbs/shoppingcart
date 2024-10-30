# Adding to a basket

- When viewing a product on the product detail page, you can add it to your basket by clicking the "Add to basket" button.
- You can see a basket icon in the header of the website. This icon will show the number of items in your basket.
- You can add multiple items to your basket.
- A basket is only created when you first try to add something to it.
- The basket is associated with your shopping session. If you close your browser, the basket will be lost.
- Multiple of the same item added to your basket are shown as a single line item with the quantity and total price.
- The basket shows a total price for all items in the basket.

---
```http
POST: /api/basket/items
Content-Type: application/json
{
  "product_id": 123,
  "quantity": 1
}
returns 204 No Content
```

Check the user request, do they have a shopping session cookie with a session id in it?
  - yes:
    - load the user session and associated basket
    - load the product by id (check it exists)
    - add the product to the basket
    - save the basket
  - no:
    - create a new user session entity
    - add a UUID to the user session
    - create a new basket entity
    - save the basket entity
    - save the user session entity, including the new basket ID
    - return a 204 No Content response, along with a Set-Cookie header with the new session ID
  - error:
    - user session cookie exists but no associated user session in DB
      - do the same as the "no session cookie" above.
    - product does not exist
      - return a 400 invalid user request

```http
GET: /api/basket
content-type: application/json
{
  "basket_id": 12,
  "line_items": [
    {
      "product_id": 123,
      "quantity": 2,
      "total_price": 10.00
    }
  ],
  "total_price": 10.00
}
200 OK
```

Check the user request, do they have a shopping session cookie with a session id in it?
  - yes:
    - load the user session and associated basket
    - load the basket items
    - return the basket items
  - no:
    - return a 200 OK response with an empty basket