OWNER
- The platform creator.
- Can manage all users, admins, tenants, channels, plans, payments, and settlements.
- Can approve, suspend, or reactivate admins.

ADMIN
- Owns or manages one tenant/business workspace.
- Can connect and manage only their own Telegram channel(s).
- Can define their plans, prices, slots, channel rules, and view their own analytics.
- Cannot access other admins' tenants, customers, channels, revenue, or advertisements.

CUSTOMER
- Can browse public channel advertising pages.
- Can create advertisements.
- Can purchase a plan for an advertisement.
- Can schedule, edit, cancel, and review only their own bookings.
- Can message an admin associated with the selected channel.

User is ADMIN
AND
the channel belongs to that user's tenant


Anyone can register as a customer.

A registered user can request to become an admin.

Only the OWNER can approve that request.

An admin cannot connect a Telegram channel or create public plans
until their tenant is approved and active.


PENDING
ACTIVE
SUSPENDED
REJECTED


A paid and valid ad is automatically scheduled and published.
    
admin defines chanel rules
Maximum text length
Allowed categories
Forbidden content
Maximum image count
Maximum video size
Minimum time between posts
Available posting times


ad editing policy
A customer may edit future scheduled posts at any time,
provided the booking is active.

A customer may request to update an already published Telegram post,
but success depends on Telegram's supported edit capabilities.

Every edit creates a new immutable ad-content version.


post now policy
"Post now" consumes one remaining post credit from the paid booking.

It is available only when:
- The booking has been paid.
- The booking is active.
- The booking has remaining post credits.
- The channel has not exceeded its rate-limit or capacity rules.
- The user owns the booking.


cancellation and refund policy
Unpaid bookings:
- Customer may cancel freely.

Paid bookings with no posts published:
- Customer may request cancellation.
- Admin or owner handles refund according to platform policy.

Paid bookings with at least one published post:
- Customer may cancel future posts.
- Automatic refunds are not implemented in MVP.
- Any refund is handled manually by the OWNER.


telegram failure policy
If Telegram publishing fails:
1. The system retries automatically with controlled backoff.
2. The system records every failed attempt.
3. After the retry limit is reached, the post is marked FAILED.
4. The customer and tenant admin are notified.
5. The admin/owner can manually retry or reschedule the failed post.


initial retry policy
Attempt 1: immediately
Attempt 2: after 1 minute
Attempt 3: after 5 minutes
Attempt 4: after 15 minutes
Attempt 5: mark as FAILED


timezone policy
Store every timestamp in PostgreSQL as UTC.

Store a timezone for every Telegram channel/tenant.

Display times to customers in the channel's configured timezone.

Convert customer-selected local time to UTC in the backend before saving.



initial mvp scope decision
MVP includes:
- Email/password registration and Google OAuth2
- OWNER, ADMIN, CUSTOMER roles
- Owner approval of admins
- One tenant and one Telegram channel per admin initially
- Configurable plans and pricing per channel
- Public channel URL and QR code
- Advertisement creation with text and image support
- Customer-selected permitted posting slots
- Click payment integration
- Backend-controlled pricing and payment verification
- Persistent scheduled posts in PostgreSQL
- Reliable Telegram publishing worker
- Edit future posts
- Publication history
- Basic revenue and commission dashboard

MVP excludes:
- Multiple channels per admin
- Multiple staff members per tenant
- Automated refunds
- Automated payouts to admins
- Full real-time chat
- Multiple payment providers
- Advanced analytics
- Video processing/transcoding
- Mobile apps


